function getUserData() {
    fetch('http://localhost:8888/moodmixer/data')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Desestructurar el json
            const {
                display_name,
                images,
                country,
                product,
                followers
            } = data;

            // Suponemos que quieres utilizar la primera imagen (índice 0)
            document.getElementById('image').src = images[0].url;

            document.getElementById('display_name').innerHTML = "Usuario: " + display_name;
            document.getElementById('country').innerHTML = "País: " + country;
            document.getElementById('product').innerHTML = "Suscripción: " + product;
            document.getElementById('followers').innerHTML = "Seguidores: " + followers.total;
        })
        .catch(e => {
            console.error('There was a problem with the fetch operation: ' + e.message);
        });
}

function topArtist() {
    // Realiza la petición
    fetch('http://localhost:8888/moodmixer/top-artists')
        .then(response => response.json())
        .then(data => {
            const container = document.querySelector('#cards-container');
            data.items.forEach(artist => {
                const card = document.createElement('div');
                card.classList.add('card');

                const imgBox = document.createElement('div');
                imgBox.classList.add('img-bx');

                const img = document.createElement('img');
                img.src = artist.images[0].url; // Obtener la URL de la primera imagen
                img.alt = 'img';


                const content = document.createElement('div');
                content.classList.add('card-content');

                const detail = document.createElement('div');
                detail.classList.add('detail');

                const h2 = document.createElement('h2');
                h2.classList.add('card-txt');
                h2.innerHTML = `${artist.name}`;

                // Añade los elementos al DOM
                imgBox.appendChild(img);
                detail.appendChild(h2);
                content.appendChild(detail);
                card.appendChild(imgBox);
                card.appendChild(content);
                container.appendChild(card);
            });
        })
        .catch(error => console.error('Error:', error));
}