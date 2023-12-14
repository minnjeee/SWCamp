// 메뉴 버튼

const toggleBtn = document.querySelector('.navbar_toggle');
const menu = document.querySelector('.navbar ul');


toggleBtn.addEventListener('click',()=> {
    menu.classList.toggle('active');
})

// 슬라이드 버튼

const btn2 = document.querySelector('.btn2');
const btn3 = document.querySelector('.btn3');
const btn1 = document.querySelector('.btn1')

btn2.addEventListener('click', () => {
    document.querySelector('.img_slider').style.transform = 'translateY(-300px)'
})

btn3.addEventListener('click',()=>{
    document.querySelector('.img_slider').style.transform = 'translateY(-610px)'
})

btn1.addEventListener('click', () => {
    document.querySelector('.img_slider').style.transform = 'translateY(0)'
})

// 탭 

const tapHtml = document.querySelectorAll('.btn_tap')[0];
const tapCss = document.querySelectorAll('.btn_tap')[1];
const tapJs = document.querySelectorAll('.btn_tap')[2];
const boxHtml = document.querySelectorAll('.content')[0];
const boxCss = document.querySelectorAll('.content')[1];
const boxJs = document.querySelectorAll('.content')[2];


tapHtml.addEventListener('click',()=> {
    tapCss.classList.remove('orange');
    tapJs.classList.remove('orange');
    tapHtml.className += ' orange';
    boxHtml.className += ' show';
    boxCss.classList.remove('show');
    boxJs.classList.remove('show');
})
tapCss.addEventListener('click',()=> {
    tapHtml.classList.remove('orange');
    tapJs.classList.remove('orange');
    tapCss.className += ' orange';
    boxHtml.classList.remove('show');
    boxCss.className += ' show';
    boxJs.classList.remove('show');
})
tapJs.addEventListener('click',()=> {
    tapHtml.classList.remove('orange');
    tapCss.classList.remove('orange');
    tapJs.className += ' orange';
    boxHtml.classList.remove('show');
    boxCss.classList.remove('show');
    boxJs.className += ' show';
})

// 로그인

const logIn = document.querySelector('.btn_login');
const alertLogIn = document.querySelector('#login');
const alertScreen = document.querySelector('.alert');
const sayHello = document.querySelector('.smile');

logIn.addEventListener('click',()=> {
    alertScreen.className += ' show_alert'
})



alertLogIn.addEventListener('click', ()=> {
   let name = document.querySelector('#name').value
   sayHello.innerText = `${name}님 안녕하세요!`;
})

const confirmBtn = document.querySelector('#enter');
confirmBtn.addEventListener('click',()=>{
    alertScreen.classList.remove('show_alert');
})