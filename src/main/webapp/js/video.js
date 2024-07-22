const body = document.querySelector('nav');

// Thêm sự kiện cuộn trang
window.addEventListener('scroll', function() {
    // Kiểm tra nếu đang cuộn xuống
    if (window.scrollY > 0) {
        // Thay đổi màu nền của body thành đen
        body.style.backgroundColor = '#000000';
    } else {
        // Nếu quay lại đầu trang, trả về màu rgba(0, 0, 0, 0)
        body.style.backgroundColor = 'rgba(0, 0, 0, 0)';
    }
});