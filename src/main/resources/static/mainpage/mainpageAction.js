var i = 0;
var txt = "Добро пожаловать на сайт ВсеДоки.ру! К чему все эти бумажки, удобное хранение документов в одном месте";

 var speed = 50;


function typeWriter() {
  if (i < txt.length) {
    document.getElementById("printText").innerHTML += txt.charAt(i);
    i++;
    setTimeout(typeWriter, speed);
  }
}
document.addEventListener("DOMContentLoaded", typeWriter);

