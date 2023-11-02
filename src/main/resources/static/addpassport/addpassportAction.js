const form = document.getElementById('form');
const seriesInput = document.getElementById('series');
const numberInput = document.getElementById('number');
const organizationInput = document.getElementById('organization');
const dateIssueInput = document.getElementById('dateIssue');
const departmentCodeInput = document.getElementById('departmentCode');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const series = seriesInput.value;
    const number = numberInput.value;
    const organization = organizationInput.value;
    const dateIssue = dateIssueInput.value;
    const departmentCode = departmentCodeInput.value;

    console.log(series, number, organization, dateIssue, departmentCode);

    try{
        const response = await fetch('/savePassport',{
            method: 'POST',
            body: JSON.stringify({series, number, organization, dateIssue, departmentCode}),
            headers:{'Content-Type' : 'application/json'}
        });
        if(response.ok){
           window.location.href = '/presentation';
        } else {
            const error = await response.json();
            const errorMassage = error.massage || 'Данные введены не корректно.';
            showErrorMessage(errorMassage)
        }
    } catch(error) {
        showErrorMessage('Данные введены не верно. Проверьте корректность введеных данных');
    }
});

function showErrorMessage(massage){
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}