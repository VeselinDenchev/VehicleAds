function cancel(vehicleType) {
    window.location = `/ads/${vehicleType}/my`;
}

function onLoad(brandId, modelName) {
    filterModels(brandId, modelName);
    togglePrice();
}

function togglePrice() {
    const isPriceNegotiableCheckbox = document.getElementById('is-price-negotiable-checkbox');
    const priceDiv = document.getElementById('price-div');
    const priceInput = document.getElementById('price-input');

    priceDiv.style.display = isPriceNegotiableCheckbox.checked ? 'none' : '';
    priceInput.required = !isPriceNegotiableCheckbox.checked;
}

togglePrice();

function filterModels(initialBrandId, initialModel, brands, models) {
    let chosenBrandId = initialBrandId || document.getElementById('brands-dropdown').value;

    const chosenBrand = brands.find(brand => brand.id === Number(chosenBrandId));
    if (!chosenBrand) return;

    const chosenBrandModels = models.filter((model) => model.brand.id === chosenBrand.id);
    if (initialModel && !chosenBrandModels.some(model => model.modelName === initialModel)) return;

    chosenBrandModels.sort((a, b) =>
        a.modelName.toLowerCase().localeCompare(b.modelName.toLowerCase()));

    const modelsDropdown = document.getElementById('models-dropdown');
    modelsDropdown.innerHTML = '';

    chosenBrandModels.forEach(function(model) {
        const option = document.createElement('option');
        option.textContent = model.modelName;
        option.value= model.modelName;

        if (initialModel && model.modelName === initialModel) {
            option.selected = true;
        }

        modelsDropdown.appendChild(option);
    });
}