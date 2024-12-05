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

  // Obtener todos los grupos de contraseña
  const passwordGroups = document.querySelectorAll('.password-group');

  // Iterar sobre cada grupo y agregar evento de clic a cada botón
  passwordGroups.forEach(group => {
      const passwordInput = group.querySelector('.password-input');
      const togglePasswordBtn = group.querySelector('.toggle-password');
      const toggleIcon = group.querySelector('.toggle-icon');

      togglePasswordBtn.addEventListener('click', function() {
          // Alternar entre 'password' y 'text'
          if (passwordInput.type === 'password') {
              passwordInput.type = 'text';
              toggleIcon.classList.remove('bi-eye-slash');
              toggleIcon.classList.add('bi-eye');
          } else {
              passwordInput.type = 'password';
              toggleIcon.classList.remove('bi-eye');
              toggleIcon.classList.add('bi-eye-slash');
          }
      });
  });