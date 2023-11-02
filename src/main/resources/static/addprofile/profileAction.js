const form = document.getElementById('forma');
const surnameInput = document.getElementById('surname');
const lastnameInput = document.getElementById('lastname');
const birthdayInput = document.getElementById('birthday');
const phoneNumberInput = document.getElementById('phoneNumber');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const surname = surnameInput.value;
    const lastname = lastnameInput.value;
    const birthday = birthdayInput.value;
    const phoneNumber = phoneNumberInput.value;

    console.log(surname, lastname, birthday, phoneNumber);

    try{
        const response = await fetch('/saveProfile',{
            method: 'POST',
            body: JSON.stringify({surname, lastname, birthday, phoneNumber}),
            headers:{'Content-Type' : 'application/json'}
        });
        if(response.ok){
           window.location.href = '/showprofile';
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