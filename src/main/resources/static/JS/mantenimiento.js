const btnMenu = document.querySelector(".btn-menu");
const buttonLeftRight = document.querySelector(".btn-menu .fa-solid");
// Un addEventListener en este contexto es una acción que ocurre en el DOM (Modelo de Objetos del Documento), como hacer clic en un botón, pasar el ratón sobre un elemento, enviar un formulario, etc.
btnMenu.addEventListener("click", () => {
  // toggle() : Método que se utiliza para alternar la presencia de una clase en el conjunto de clases del elemento.
  
  buttonLeftRight.classList.toggle("fa-circle-chevron-left");
  buttonLeftRight.classList.toggle("fa-circle-chevron-right");
  
  document.querySelector(".ds-left-menu").classList.toggle("menu-active");
  document.querySelector(".ds-panel").classList.toggle("tab-menu");
});


(() => {
    'use strict'
  
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')
  
    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
      form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
  
        form.classList.add('was-validated')
      }, false)
    })
  })()



   // Selecciona todos los inputs de archivo
   const inputFiles = document.querySelectorAll('input[type="file"]');

   // Itera sobre cada input de archivo
   inputFiles.forEach(inputFile => {
     const pictureImage = inputFile.previousElementSibling.querySelector(".picture__image");
     const containerImg = inputFile.previousElementSibling;

     // Establece el texto por defecto
     pictureImage.innerHTML = "Seleccionar Imagen";

     inputFile.addEventListener("change", function (e) {
       const inputTarget = e.target;
       const file = inputTarget.files[0];

       if (file) {
         const reader = new FileReader();

         reader.addEventListener("load", function (e) {
           const readerTarget = e.target;

           const img = document.createElement("img");
           img.src = readerTarget.result;
           img.classList.add("picture__img", "img-fluid");

           pictureImage.innerHTML = ""; // Limpia el texto
           pictureImage.appendChild(img); // Añade la imagen
           containerImg.classList.remove("p-3"); // Quita el padding
         });

         reader.readAsDataURL(file);
       } else {
         containerImg.classList.add("p-3"); // Vuelve a agregar el padding
         pictureImage.innerHTML = "Choose an image"; // Restaura el texto por defecto
       }
     });
   });