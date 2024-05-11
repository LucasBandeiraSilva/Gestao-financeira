const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const senha = document.getElementById("senha");
let isInvalidComparePassword = true;
let isInvalidPassword = true;

function setError(index) {
  campos[index].classList.add("is-invalid");
  spans[index].style.display = "block";
  spans[index].classList.add("invalid-feedback");
}
function removeError(index) {
  campos[index].classList.remove("is-invalid");
  spans[index].classList.remove("invalid-feedback");
  spans[index].style.display = "none";
}

function passwordValidate() {
  if (campos[0].value.length < 6) {
    setError(0);
    isInvalidPassword = false;
  } else {
    removeError(0);
    isInvalidPassword = true;
  }
}

function comparePassword() {
  if (campos[0].value.length !== campos[1].value.length) {
    setError(1);
    isInvalidPassword = false;
  } else {
    removeError(1);
    isInvalidPassword = true;
  }
}
form.addEventListener("submit", (event) => {
    if (isInvalidComparePassword && !isInvalidPassword) {
      console.log("formulario não enviado");
      console.log("senha boolean: " + isInvalidPassword);
      console.log("compareSenha boolean: " + isInvalidComparePassword);
      event.preventDefault();
    }else{
      console.log("form sem erros de senha")
    }
    
  });
