const form = document.getElementById('form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const username = usernameInput.value;
    const password = passwordInput.value;

    console.log(username, password);

    try{
        const response = await fetch('/authorizationPerson',{
            method: 'POST',
            body: JSON.stringify({username,password}),
            headers:{'Content-Type' : 'application/json'}
        });
        if(response.ok){
           window.location.href = '/mainpage';
        } else {
            const error = await response.json();
            const errorMassage = error.massage || 'Пользователь не зарегистрирован!';
            showErrorMessage(errorMassage)
        }
    } catch(error) {
        showErrorMessage('Данный пользователь не зарегистрирован в системе. Проверьте введенные данные или зарегистрируйтесь');
    }
});

function showErrorMessage(massage){
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}


