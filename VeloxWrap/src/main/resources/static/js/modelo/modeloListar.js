$(document).ready(function () {
$('#datatable').DataTable({
    language: {
        processing: "Processando...",
        lengthMenu: "Mostrar _MENU_ registros",
        zeroRecords: "Nenhum usuário encontrado",
        info: "Mostrando _START_ a _END_ de _TOTAL_ modelos",
        search: "Buscar:",
        paginate: {
            first: "Primeiro",
            previous: "Anterior",
            next: "Próximo",
            last: "Último"
        }
    },

    order: [[0, 'asc']], // 👈 exemplo: ordenar por nome ao invés de ID

    columnDefs: [
        {orderable: false, targets: 4} // ações
    ]
});
});
function deletar(id) {

Swal.fire({
    title: 'Excluir Modelo?',
    text: "Essa ação não poderá ser revertida!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6',
    confirmButtonText: 'Sim, excluir',
    cancelButtonText: 'Cancelar'
}).then((result) => {

    if (result.isConfirmed) {

        fetch('/modelos/' + id, {
            method: 'DELETE'
        })
            .then(resp => {

                if (resp.ok) {

                    Swal.fire(
                        'Excluído!',
                        'Modelo removido com sucesso.',
                        'success'
                    ).then(() => location.reload());

                } else {

                    Swal.fire('Erro', 'Falha ao excluir Modelo.', 'error');
                }

            })
            .catch(() => {
                Swal.fire('Erro', 'Erro de conexão com servidor.', 'error');
            });
    }

});

}