from flask import Flask, jsonify
import requests
import json
from flask_caching import Cache

# Creiamo l'applicazione Flask
app = Flask(__name__)

# Configurazione per il caching
cache = Cache(app, config={'CACHE_TYPE': 'simple'})  # Cache in memoria semplice

# Definiamo una rotta per ottenere i dettagli di un Pokémon
@app.route('/pokemon/<name>', methods=['GET'])
@cache.cached(timeout=60)  # Cache per 60 secondi
def get_pokemon(name):
    try:
        # Verifica se il Pokémon è presente nella cache locale
        response = requests.get(f"https://pokeapi.co/api/v2/pokemon/{name}")
        if response.status_code == 200:
            data = response.json()

            # Access the values of 'weight' and 'height'
            weight = data.get('weight')
            height = data.get('height')
            return "weight: "+str(weight)+" height: "+str(height)
        else:
            return jsonify({'error': 'Pokémon non trovato'}), 404  # Errore se il Pokémon non esiste
    except Exception as e:
        return jsonify({'error': str(e)}), 500  # Gestione degli errori

# Avviamo l'applicazione Flask
#if __name__ == '__main__':
app.run(debug=True)
