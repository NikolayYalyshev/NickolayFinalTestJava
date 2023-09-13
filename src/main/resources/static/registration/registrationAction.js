const form = document.getElementById('form');
const usernameInput = document.getElementById('username');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const username = usernameInput.value;
    const email = emailInput.value;
    const password = passwordInput.value;

    console.log(username, email, password);

    try{
        const response = await fetch('/person',{
            method: 'POST',
            body: JSON.stringify({username,email,password}),
            headers:{'Content-Type' : 'application/json'}
        });
        if(response.ok){
            window.location.href = '/demo/mainpage';
        } else {
            const error = await response.json();
            const errorMassage = error.massage || 'Произошла ошибка';
            showErrorMessage(errorMassage)
        }
    } catch(error) {
        showErrorMessage("Произошла ошибка")
    }
});

function showErrorMessage(massage){
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}


