document.addEventListener("DOMContentLoaded", function() {
    const baseUrl = 'https://pokeapi.co/api/v2/pokemon/';
    const pokemonList = document.getElementById('pokemon-list');
    const popup = document.getElementById('pokemon-popup');
    const popupContent = document.getElementById('pokemon-details');
    const closeBtn = document.querySelector('.close-btn');

    function fetchPokemons(limit = 150) {
        fetch(`${baseUrl}?limit=${limit}`)
            .then(response => response.json())
            .then(data => {
                data.results.forEach(pokemon => {
                    fetchPokemonData(pokemon.url);
                });
            });
    }

    function fetchPokemonData(url) {
        fetch(url)
            .then(response => response.json())
            .then(pokemonData => {
                const pokemonDiv = document.createElement('div');
                pokemonDiv.className = 'pokemon';
                pokemonDiv.innerHTML = `
                    <img src="${pokemonData.sprites.front_default}" alt="${pokemonData.name}" style="width:100%;">
                    <h3>${pokemonData.name}</h3>
                `;
                pokemonDiv.onclick = () => showPokemonDetails(pokemonData);
                pokemonList.appendChild(pokemonDiv);
            });
    }

    function showPokemonDetails(pokemon) {
        popupContent.innerHTML = `
            <h2>${pokemon.name}</h2>
            <img src="${pokemon.sprites.front_default}" alt="${pokemon.name}" style="width:50%;">
            <p>Height: ${pokemon.height}</p>
            <p>Weight: ${pokemon.weight}</p>
        `;
        popup.style.display = 'flex';
    }

    closeBtn.onclick = () => {
        popup.style.display = 'none';
    }

    fetchPokemons();
});