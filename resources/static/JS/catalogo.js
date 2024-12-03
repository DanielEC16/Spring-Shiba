document.querySelectorAll('.btn-plus').forEach(button => {
    button.addEventListener('click', function() {
        const quantityInput = this.parentElement.querySelector('.quantity');
        let quantity = parseInt(quantityInput.value);
        quantityInput.value = ++quantity;
        toggleMinusButton(quantityInput);
    });
});

document.querySelectorAll('.btn-minus').forEach(button => {
    button.addEventListener('click', function() {
        const quantityInput = this.parentElement.querySelector('.quantity');
        let quantity = parseInt(quantityInput.value);
        if (quantity > 1) {
            quantityInput.value = --quantity;
        }
        toggleMinusButton(quantityInput);
    });
});

function toggleMinusButton(quantityInput) {
    const minusButton = quantityInput.parentElement.querySelector('.btn-minus');
    minusButton.disabled = quantityInput.value <= 1;
}

