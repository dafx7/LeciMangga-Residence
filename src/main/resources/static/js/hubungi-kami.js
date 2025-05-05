const form = document.getElementById('hubungiKamiForm');
const usernameInput = document.getElementById('nama');
const emailInput = document.getElementById('email');
const pesanInput = document.getElementById('pesan')
const usernameError = document.getElementById('usernameError');
const emailError = document.getElementById('emailError');
const pesanError = document.getElementById('pesanError')

form.addEventListener('submit', function (e) {
    let valid = true;

    // Username validation
    if (usernameInput.value.trim() === "") {
        usernameError.classList.remove('hidden');
        usernameInput.classList.add('border-red-500', 'ring-2', 'ring-red-300');
        valid = false;
    } else {
        usernameError.classList.add('hidden');
        usernameInput.classList.remove('border-red-500', 'ring-2', 'ring-red-300');
    }

    // Email validation using simple regex
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(emailInput.value.trim())) {
        emailError.classList.remove('hidden');
        emailInput.classList.add('border-red-500', 'ring-2', 'ring-red-300');
        valid = false;
    } else {
        emailError.classList.add('hidden');
        emailInput.classList.remove('border-red-500', 'ring-2', 'ring-red-300');
    }

    // pesan validation
    if (pesanInput.value.trim() === "") {
        pesanError.classList.remove('hidden');
        pesanInput.classList.add('border-red-500', 'ring-2', 'ring-red-300');
        valid = false;
    } else {
        pesanError.classList.add('hidden');
        pesanError.classList.remove('border-red-500', 'ring-2', 'ring-red-300');
    }

    if (!valid) {
        e.preventDefault(); // Stop form submission if any field is invalid
    }
});