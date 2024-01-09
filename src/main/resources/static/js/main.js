// 마이 페이지 토글바
const myPageBtn = document.querySelector('.main_mypage');
const myPageBox = document.querySelector('.myPage_menus');

myPageBtn.addEventListener('click', () => {
    myPageBox.classList.toggle('show');
})


// 이미지 슬라이드
const slide_img = document.querySelectorAll('.slide_img')
var counter = 0;
var intervalId;

slide_img.forEach(
    (slide, index) => {
        slide.style.left = `${index * 100}%`
    }
)

const goPrev = () => {
    counter--
    if(counter == -1) {
        counter = 2
    }
    slideImage()
}
const goNext = () => {
    counter++
    if(counter == 3) {
        counter = 0
    }
    slideImage()
}

const slideImage = () => {
    slide_img.forEach(
        (slide) => {
            slide.style.transform = `translateX(-${counter * 100}%)`
        }
    )
}

// 3초마다 자동으로 넘어가도록 설정
const startAutoSlide = () => {
    intervalId = setInterval(goNext, 4000); // 3000 밀리초(3초) 간격으로 goNext 함수 호출
};

// 페이지 로드 시 자동 슬라이드 시작
startAutoSlide();


// 텍스트 애니메이션 구현
let target = document.querySelector('#dynamic');

function randomString() {
    let stringList = [
        "반려동물과 함께하는 나만의 개인 비서",
        "내 반려동물을 위한 똑똑한 반려동물 지도",
        "반려동물과 함께하는 여행을 위해",
        "반려동물과 함께 만드는 추억",
        "반려동물과 함께하고 싶은 여러분을 위해",
        "강아지와 함께하고 싶은 여러분을 위해",
        "세상에 하나뿐인 펫맵",
        "전국 곳곳을 반려동물과 함께",
    ];
    let selectString = stringList[Math.floor(Math.random() * stringList.length)];
    let selectedStringAl = selectString.split("");
    return selectedStringAl;
}
function resetTyping() {
    target.textContent = "";
    dynamic(randomString());
}
function dynamic(randomList) {
    if (randomList.length > 0) {
        target.textContent += randomList.shift();
        setTimeout(function() {
            dynamic(randomList);
        }, 80);
    } else {
        setTimeout(resetTyping, 2000);
    }
}
dynamic(randomString());
function twinkle() {
    target.classList.toggle("twinkle");
}
setInterval(twinkle, 500);

