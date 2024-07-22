package Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Videos.findByKeyword", query="SELECT o FROM Videos o WHERE o.title LIKE :keyword"),
	@NamedQuery(name="Videos.findAll", query="SELECT o FROM Videos o WHERE o.active = true"),
	@NamedQuery(name="Videos.findAllAdmin", query="SELECT o FROM Videos o"),
	@NamedQuery(name="Videos.findById", query="SELECT o FROM Videos o WHERE o.id =:videoId"),
	@NamedQuery(name="Videos.findByType", query="SELECT o FROM Videos o WHERE o.type = :videoType AND o.id != :videoId")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="Report.random3", query="SELECT TOP 3 * FROM Videos ORDER BY newid()", resultClass = Videos.class)
})

@Entity
@Table(name="videos")
public class Videos {
	@Id
	String id;
	String title;
	String poster;
	String description;
	Integer views = 0;
	Boolean active = true;
	String owner;
	String url;
	String type;
	@OneToMany(mappedBy="video")
	List<Favourites> favourites;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Favourites> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Favourites> favourites) {
		this.favourites = favourites;
	}
	
}
