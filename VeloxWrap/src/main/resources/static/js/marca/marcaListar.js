$(document).ready(function () {
    $('#datatable').DataTable({
        language: {
            processing: "Processando...",
            lengthMenu: "Mostrar _MENU_ registros",
            zeroRecords: "Nenhum usuário encontrado",
            info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
            search: "Buscar:",
            paginate: {
                first: "Primeiro",
                previous: "Anterior",
                next: "Próximo",
                last: "Último"
            }
        },

        order: [[0, 'asc']],

        columnDefs: [
            { orderable: false, targets: 3 }
        ]
    });
});

function deletar(id) {

    Swal.fire({
        title: 'Excluir marca?',
        text: "Essa ação não poderá ser revertida!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#3085d6',
        confirmButtonText: 'Sim, excluir',
        cancelButtonText: 'Cancelar'
    }).then((result) => {

        if (result.isConfirmed) {

            fetch('/marcas/' + id, {
                method: 'DELETE'
            })
                .then(resp => {

                    if (resp.ok) {

                        Swal.fire(
                            'Excluído!',
                            'Marca removida com sucesso.',
                            'success'
                        ).then(() => {
                            location.reload();
                        });

                    } else {
                        Swal.fire('Erro', 'Falha ao excluir marca.', 'error');
                    }

                })
                .catch(() => {
                    Swal.fire('Erro', 'Erro de conexão com servidor.', 'error');
                });

        }

    });
}