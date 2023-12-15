function deleteArtist(button) {
    var idArtist = button.closest('tr').querySelector('td').dataset.id;
    console.log(idArtist);

    fetch('http://localhost:8888/moodmixer/table/' + idArtist, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                console.log('Error put');
            }
            showTable();
        })
}