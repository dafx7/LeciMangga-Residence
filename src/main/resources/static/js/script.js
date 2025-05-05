const iconHamburger = document.getElementById("icon-Hamburger")
const menuList = document.getElementById("menu-List")

iconHamburger.addEventListener("click",() =>{
    menuList.classList.toggle("hidden")
})