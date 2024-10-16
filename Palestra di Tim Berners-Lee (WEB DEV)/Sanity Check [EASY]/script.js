const pokemons = [
    { name: "Pikachu", image: "https://img.pokemondb.net/sprites/home/normal/pikachu.png" },
    { name: "Charmander", image: "https://img.pokemondb.net/sprites/home/normal/charmander.png" },
    { name: "Bulbasaur", image: "https://img.pokemondb.net/sprites/home/normal/bulbasaur.png" },
    { name: "Squirtle", image: "https://img.pokemondb.net/sprites/home/normal/squirtle.png" },
];

const button = document.getElementById('change-pokemon-btn');
const pokemonName = document.getElementById('pokemon-name');
const pokemonImage = document.getElementById('pokemon-image');

button.addEventListener('click', () => {
    const randomIndex = Math.floor(Math.random() * pokemons.length);
    pokemonName.textContent = pokemons[randomIndex].name;
    pokemonImage.src = pokemons[randomIndex].image;
});
