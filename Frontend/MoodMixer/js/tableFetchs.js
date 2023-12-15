function showTable() {
    fetch('http://localhost:8888/moodmixer/table', {
        method: 'GET',
    }).then(response => response.json())
        .then(data => {
            let container = document.getElementById('dinamic-container');
            container.innerHTML = "";
            data.forEach(artist => {
                let row = document.createElement('tr');

                let idCell = document.createElement('td');
                idCell.dataset.id = artist.id_artist;
                idCell.textContent = artist.id_artist;
                row.appendChild(idCell);

                let nameCell = document.createElement('td');
                nameCell.textContent = artist.name;
                row.appendChild(nameCell);

                let genreCell = document.createElement('td');
                genreCell.textContent = artist.genres;
                row.appendChild(genreCell);

                let linkCell = document.createElement('td');
                linkCell.textContent = artist.url;
                row.appendChild(linkCell);

                let actionCell = document.createElement('td');

                let deleteButton = document.createElement('button');
                deleteButton.textContent = 'Eliminar Artista';
                deleteButton.addEventListener('click', function () {
                    deleteArtist(this);
                });
                deleteButton.className = 'btns';
                actionCell.appendChild(deleteButton);

                row.appendChild(actionCell);

                container.appendChild(row);
            });

        })
        .catch(error => console.log(error));
}

setTimeout(showTable, 1000);