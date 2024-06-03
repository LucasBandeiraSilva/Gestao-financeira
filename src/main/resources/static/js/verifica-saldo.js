const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const invalidFeedback = document.querySelectorAll(".span-required");
const validFeedback = document.querySelectorAll(".valid");
const saldo = document.getElementById("saldoCliente").innerText;
const saldoConvertido = parseFloat(saldo)
let isInvalidSaldo = true

function setError(index) {
    campos[index].classList.add("is-invalid")
    invalidFeedback[index].classList.add("d-block")
    invalidFeedback[index].classList.add("invalid-feedback")
    validFeedback[index].classList.remove("d-block")
    validFeedback[index].classList.remove("valid-feedback")
    campos[index].classList.remove("is-valid")
}
function setSuccess(index) {
    campos[index].classList.remove("is-invalid")
    campos[index].classList.add("is-valid")
    invalidFeedback[index].classList.remove("d-block")
    validFeedback[index].classList.add("d-block")
}

function validarValor(){
    const valor = parseFloat(campos[0].value.replace(".", ""));
    console.log("saldo convertido é: "+  valor)

    if(valor>= saldoConvertido){
        setError(0)
        isInvalidSaldo = true
    }else{
        setSuccess(0)
        isInvalidSaldo = false
    }
}

form.addEventListener("submit",(event)=>{
    validarValor();
    if(isInvalidSaldo){
        event.preventDefault();
    }
})


