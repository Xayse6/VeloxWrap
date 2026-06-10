$(document).ready(function () {

    $('#formMarca').on('submit', function (e) {

        e.preventDefault();

        let id = $('#idMarca').val();

        let url = '/MarcaCadastrar';
        let method = 'POST';

        // se tem ID → UPDATE
        if (id && id.trim() !== '') {
            url = '/marcas/' + id;
            method = 'PUT';
        }

        $.ajax({

            type: method,
            url: url,
            contentType: 'application/json',
            data: JSON.stringify({
                idMarca: id,
                nomeMarca: $('#nomeMarca').val(),
                siglaMarca: $('#siglaMarca').val()
            }),

            success: function (data) {

                if (data.trim() === "1") {

                    Swal.fire({
                        icon: 'success',
                        title: 'Sucesso!',
                        text: 'Marca salva com sucesso!',
                        timer: 2000,
                        showConfirmButton: false
                    }).then(() => {
                        window.location.href = '/marcas';
                    });

                } else {

                    Swal.fire({
                        icon: 'error',
                        title: 'Erro',
                        text: 'Não foi possível salvar.'
                    });
                }
            },

            error: function () {

                Swal.fire({
                    icon: 'error',
                    title: 'Erro',
                    text: 'Falha no servidor.'
                });

            }

        });

    });

});
