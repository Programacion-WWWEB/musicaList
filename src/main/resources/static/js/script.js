// JavaScript para mostrar/ocultar el menú al hacer clic en el botón de "Géneros"
document.getElementById("generos-btn").addEventListener("click", function () {
		var menuList = document.getElementById("menu-list");
		if (menuList.style.display === "block") {
				menuList.style.display = "none";
		} else {
				menuList.style.display = "block";
		}
});