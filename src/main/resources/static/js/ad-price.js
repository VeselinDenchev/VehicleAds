function togglePriceRange() {
    const isPriceNegotiableCheckbox = document.getElementById('is-price-negotiable-checkbox');
    const priceRangeElements = document.querySelectorAll('.price-input-group');

    priceRangeElements.forEach(
        function(element) {
            element.style.display = isPriceNegotiableCheckbox.checked ? 'none' : '';
        }
    );
}

function validateAndSubmit() {
    var form = document.getElementById('ad-search-form');

    const isPriceNegotiableCheckbox = document.getElementById('is-price-negotiable-checkbox');

    if (isPriceNegotiableCheckbox.checked) {
        const minPriceInput = document.getElementById('min-price-input');
        const maxPriceInput = document.getElementById('max-price-input');

        minPriceInput.value = null;
        maxPriceInput.value = null;
    }

    var inputs = form.querySelectorAll('input');

    inputs.forEach(input => {
        if (input.value.trim() === '') {
            input.removeAttribute('name');
        }
    });

    form.submit();
}

// function formatPrice() {
//     const minPriceInput= document.getElementById('min-price-input')
//     const maxPriceInput= document.getElementById('max-price-input')
//     const adPrices = document.getElementsByClassName('.ad-price');
//
//     const prices = [...adPrices, minPriceInput, maxPriceInput];
//     prices.forEach((price) => {
//         if (price != null) {
//             price.value = Number(price.value).toFixed(2);
//         }
//     })
// }