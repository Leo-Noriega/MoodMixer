function modifyArtist() {
    let idArtist = document.getElementById('id-artist').value;
    console.log(idArtist);
    let nameArtist = document.getElementById('name-artist').value;
    console.log(nameArtist);
    let genresArtist = document.getElementById('genre-artist').value;
    console.log(genresArtist);
    let linkArtist = document.getElementById('link-artist').value;
    console.log(linkArtist);
    fetch('http://localhost:8888/moodmixer/table', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id_artist: idArtist,
            name: nameArtist,
            genres: genresArtist,
            url: linkArtist,
        })
    })
        .then(response => {
            if (!response.ok) {
                console.log('Error put');
            }
            showTable();
        })
}