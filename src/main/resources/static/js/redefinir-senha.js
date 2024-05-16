const form = document.getElementById("form");
const spans = document.querySelectorAll(".span-required");
const campos = document.querySelectorAll(".required");
const validFeedback = document.querySelectorAll(".valid");

function setError(index) {
  campos[index].classList.add("is-invalid");
  spans[index].classList.add("invalid-feedback");
  spans[index].style.display = "block";
}
function removeError(index) {
  campos[index].classList.remove("is-invalid");
  spans[index].classList.remove("invalid-feedback");
  spans[index].style.display = "none";
  campos[index].classList.add("is-valid");
  validFeedback[index].classList.add("valid-feedback");
  validFeedback[index].style.display = "block";
}

function validatePassword() {
  if (campos[0].value.length < 6) {
    setError(0);
  } else {
    removeError(0);
  }
}

function comparePassword() {
  if (campos[0].value.length != campos[1].value.length) {
    setError(1);
  } else {
    removeError(1);
  }
}
