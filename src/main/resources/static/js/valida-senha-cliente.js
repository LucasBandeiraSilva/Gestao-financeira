const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const validFeedback = document.querySelectorAll(".valid");
let isInvalidComparePassword = true;
let isInvalidPassword = true;
let isInValidName = true;

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
  validFeedback[index].classList.add("valid-feedback");
  validFeedback[index].style.display = "block";
}

function nameValidation() {
  if (campos[0].value.length < 3) {
    setError(0);
    isInValidName = true;
  } else {
    removeError(0);
    isInValidName = false;
  }
}

function passwordValidate() {
  if (campos[1].value.length < 6) {
    setError(1);
    isInvalidPassword = true;
  } else {
    removeError(1);
    isInvalidPassword = false;
  }
}

function comparePassword() {
  if (campos[1].value !== campos[2].value) {
    setError(2);
    isInvalidComparePassword = true;
  } else {
    removeError(2);
    isInvalidComparePassword = false;
  }
}

form.addEventListener("submit", (event) => {
  nameValidation();
  passwordValidate();
  comparePassword();

  if (isInValidName || isInvalidPassword || isInvalidComparePassword) {
    console.log("formulario não enviado");
    console.log("senha boolean: " + isInvalidPassword);
    console.log("compareSenha boolean: " + isInvalidComparePassword);
    console.log("nameValidation boolean: " + isInValidName);
    event.preventDefault();
  } else {
    console.log("form sem erros de senha");
  }
});
