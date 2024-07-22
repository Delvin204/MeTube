const curent = document.querySelector('.active-link');
console.log(curent);
document.addEventListener("DOMContentLoaded", function() {
    const links = document.querySelectorAll('.nav-link');
    
    links.forEach(function(link) {
        link.addEventListener('click', function(event) {
            links.forEach(function(otherLink) {
                otherLink.classList.remove('active-link');
            });
            this.classList.add('active-link');
        });

        link.addEventListener('mouseenter', function(event) {
            this.classList.add('active-link');
        });

        link.addEventListener('mouseleave', function(event) {
            this.classList.remove('active-link');
            curent.classList.add('active-link');
        });
    });
});
