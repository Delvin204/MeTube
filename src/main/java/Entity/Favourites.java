package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@NamedQueries({
	@NamedQuery(name="Favourites.findVideoByUserId", query = "SELECT o.video FROM Favourites o WHERE o.user.id =:id"),
	@NamedQuery(name="Favourites.findFavouriteByVideoId", query = "SELECT o.video FROM Favourites o WHERE o.video.id LIKE :videoId"),
	@NamedQuery(name="Favourites.findVideoByDate", query = "SELECT o FROM Favourites o WHERE o.likeDate BETWEEN :dateStart AND :dateEnd"),
	@NamedQuery(name="Favourites.countLike", query = "SELECT COUNT(o.id) FROM Favourites o WHERE o.video.id =:id"),
	@NamedQuery(name="Favourite.findIsLiked", query="SELECT COUNT(o) FROM Favourites o WHERE o.video.id = :videoId AND o.user.id = :userId")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="Favourites.top3", query="SELECT TOP 3 * FROM Videos ORDER BY views DESC", resultClass = Videos.class)
})

@Entity
@Table(name="favourites", uniqueConstraints = {@UniqueConstraint(columnNames = {"videoId","userId"})}) //Ràng buộc duy nhất
public class Favourites {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Field tự tăng
	Long id;
	@ManyToOne @JoinColumn(name="userID") //Khóa ngoại
	Users user;
	@ManyToOne @JoinColumn(name="videoId") //Khóa ngoại
	Videos video;
	@Temporal(TemporalType.DATE) //Kiểu thời gian
	Date likeDate = new Date();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
}
