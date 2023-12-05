function topArtist() {
    fetch('http://localhost:8888/moodmixer/top-artists')
        .then(response => {
            if (!response.ok) {
                throw new Error('HTTP error, status = ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            const {
                name,
                // images,
                popularity,
                uri,
            } = data;
            // document.getElementById("card_img").src = images[1].url;
            document.getElementById("card_title").innerHTML = name;
            document.getElementById("card_description").innerHTML = "Ranking global: " + popularity;
            document.getElementById("card").href = uri;
            //quitarle hidden a la etiqueta a con id card
            document.getElementById("card").hidden = false;
        })
}