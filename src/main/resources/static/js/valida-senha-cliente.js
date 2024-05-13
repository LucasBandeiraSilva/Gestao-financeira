const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const validFeedback = document.querySelectorAll(".valid");
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
  campos[index].classList.add("is-valid");
  validFeedback[index].classList.add("valid-feedback")
  validFeedback[index].style.display="block"
}

function nameValidation(){
  if(campos[0].value.length < 3){
    setError(0);
  }else
  removeError(0);
}
function passwordValidate() {
  if (campos[1].value.length < 6) {
    setError(1);
    isInvalidPassword = false;
  } else {
    removeError(1);
    isInvalidPassword = true;
  }
}

function comparePassword() {
  if (campos[1].value.length !== campos[2].value.length) {
    setError(2);
    isInvalidPassword = false;
  } else {
    removeError(2);
    isInvalidPassword = true;
  }
}
form.addEventListener("submit", (event) => {
  if (isInvalidComparePassword && !isInvalidPassword) {
    console.log("formulario não enviado");
    console.log("senha boolean: " + isInvalidPassword);
    console.log("compareSenha boolean: " + isInvalidComparePassword);
    event.preventDefault();
  } else {
    console.log("form sem erros de senha");
  }
});
