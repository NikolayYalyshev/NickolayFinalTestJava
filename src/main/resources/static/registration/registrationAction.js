const form = {
    name: document.getElementById('name'),
    email: document.getElementById('email'),
    password: document.getElementById('password'),
    button: document.querySelector('button'),
    error: document.querySelector('.input-error')
}

function checkForm() {
    const name = form.name.getElementsByTagName('input')[0].value
    const email = form.email.getElementsByTagName('input')[0].value
    const password = form.password.getElementsByTagName('input')[0].value
    if(name && email && password) {
        form.button.classList.remove('disable')
    } else {
        form.button.classList.add('disable')
    }
}

function hundleInput(e, name) {
    const { value } = e.target
    if(value) {
        form[name].classList.add('filed')
    } else {
        form[name].classList.remove('filed')
    }
    checkForm()
}

function validateEmail() {
    const { value } = form.email.getElementsByTagName('input')[0]
    const reg = /[a-z]{3,20}@[a-z]{3,10}\.[a-z]{2,4}/
    console.log(value)
    if(reg.test(value)){
        form.email.classList.remove('error')
        form.error.classList.remove('view')
    } else {
        form.button.classList.add('disable')
        form.email.classList.add('error')
        form.error.classList.add('view')
    }
}

form.name.oninput = (e) => hundleInput(e, 'name')
form.email.oninput = (e) => hundleInput(e, 'email')
form.password.oninput = (e) => hundleInput(e, 'password')
form.button.onclick = validateEmail

const doc = document.getElementById('form')
const usernameInput = document.getElementById('username')
const emailInput = document.getElementById('user-email')
const passwordInput = document.getElementById('user-password')

function showErrorMessage(massage){
    const errorElement = document.createElement('span')
    errorElement.classList.add('error-massage')
    errorElement.textContent = massage
    doc.appendChild(errorElement)
}

doc.addEventListener('submit', async (event) => {
    event.preventDefault()

       const name = usernameInput.value
      const email = emailInput.value
      const password = passwordInput.value

      console.log(name, email, password)

    try{
        const response = await fetch('/Person', {
            method: 'POST',
            body: JSON.stringify({name, email, password}),
            headers:{'Content-Type' : 'application/json'}
        })
        if(response.ok){
            window.location.href = '/mainpage'
        } else {
            const error = await response.json()
            const errorMassage = error.massage || 'Произошла ошибка'
            showErrorMessage(errorMassage)
        }
    } catch(error) {
        showErrorMessage("Произошла ошибка")
    }
});

