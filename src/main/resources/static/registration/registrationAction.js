const form = document.getElementById('form');
document.addEventListener("DOMContentLoaded", function() {

    const inputs = form.querySelectorAll('input[type="text"], input[type="email"], input[type="password"]');
    const button = form.querySelector('.button');

    function checkForm() {
        const name = form.querySelector('input[name="name"]').value;
        const email = form.querySelector('input[name="email"]').value;
        const password = form.querySelector('input[name="password"]').value;

        console.log(name, email, password);

        if (name && email && password) {
            button.classList.remove('disable');
            button.disabled = false;
        } else {
            button.classList.add('disable');
            button.disabled = true;
        }
    }

    inputs.forEach(input => {
        input.addEventListener('input', checkForm);
    });
});

function showErrorMessage(massage){
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const username = form.querySelector('input[name="name"]').value;
        const email = form.querySelector('input[name="email"]').value;
        const password = form.querySelector('input[name="password"]').value;

      console.log(username, email, password);

    try{
        const response = await fetch('/person', {
            method: 'POST',
            body: JSON.stringify({username, email, password}),
            headers:{'Content-Type' : 'application/json'}
        })
        if(response.ok){
            window.location.href = '/mainpage';
        } else {
            const error = await response.json();
            const errorMassage = error.massage || 'Произошла ошибка';
            showErrorMessage(errorMassage)
        }
    } catch(error) {
        showErrorMessage("Произошла ошибка")
    }
});


