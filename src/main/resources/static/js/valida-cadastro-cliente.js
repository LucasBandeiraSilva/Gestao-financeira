const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const validFeedback = document.querySelectorAll(".valid");
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
let isInvalidComparePassword = true;
let isInvalidPassword = true;
let isInValidName = true;
let isInvalidCpf = true;
let isInvalidEmail = true;

function setError(index) {
  campos[index].classList.add("is-invalid");
  spans[index].style.display = "block";
  spans[index].classList.add("invalid-feedback");
  campos[index].classList.remove("is-valid");
  validFeedback[index].style.display = "none";
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

function emailValidator() {
  const email = document.getElementById("email").value;
  if (!emailRegex.test(email)) {
    setError(1);
    isInvalidEmail = true;
  } else {
    removeError(1);
    isInvalidEmail = false;
  }
}

function CpfValido(cpf) {
  if (cpf == "00000000000") return false;

  if (cpf.length != 11) return false;

  let soma = 0;
  let resto;

  for (let i = 1; i <= 9; i++) {
    soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
  }

  resto = (soma * 10) % 11;
  if (resto == 10 || resto == 11) resto = 0;

  if (resto != parseInt(cpf.substring(9, 10))) return false;

  soma = 0;
  for (let i = 1; i <= 10; i++) {
    soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
  }

  resto = (soma * 10) % 11;
  if (resto == 10 || resto == 11) resto = 0;

  if (resto != parseInt(cpf.substring(10, 11))) return false;
  return true;
}

function cpfValidator() {
  const cpf = document.getElementById("cpf").value;
  if (!CpfValido(cpf)) {
    setError(2);
    isInvalidCpf = true;
  } else {
    removeError(2);
    isInvalidCpf = false;
  }
}

function passwordValidate() {
  if (campos[3].value.length < 6) {
    setError(3);
    isInvalidPassword = true;
  } else {
    removeError(3);
    isInvalidPassword = false;
  }
}

function comparePassword() {
  if (campos[4].value !== campos[3].value) {
    setError(4);
    isInvalidComparePassword = true;
  } else {
    removeError(4);
    isInvalidComparePassword = false;
  }
}

form.addEventListener("submit", (event) => {
  nameValidation();
  emailValidator();
  cpfValidator();
  passwordValidate();
  comparePassword();

  if (
    isInValidName ||
    isInvalidEmail ||
    isInvalidCpf ||
    isInvalidPassword ||
    isInvalidComparePassword
  ) {
    event.preventDefault();
  } else {
    console.log("form sem erros de senha");
  }
});
