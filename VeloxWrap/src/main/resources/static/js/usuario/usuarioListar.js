$(document).ready(function () {

    $('#datatable').DataTable({
        language: {
            processing: "Processando...",
            lengthMenu: "Mostrar _MENU_ registros",
            zeroRecords: "Nenhum usuário encontrado",
            info: "Mostrando _START_ a _END_ de _TOTAL_ usuários",
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
            { orderable: false, targets: 5 } // ações
        ]
    });

    // ✔ MÁSCARA CPF NA TABELA
    $('.cpf').each(function () {
    let v = $(this).text().replace(/\D/g, '');

    if (v.length === 11) {
    v = v.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
    $(this).text(v);
}
});

});

    // ✔ EXCLUIR USUÁRIO (CORRIGIDO REST)
    function deletar(id) {

    Swal.fire({
        title: 'Excluir usuário?',
        text: "Essa ação não poderá ser revertida!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#3085d6',
        confirmButtonText: 'Sim, excluir',
        cancelButtonText: 'Cancelar'
    }).then((result) => {

        if (result.isConfirmed) {

            fetch('/usuarios/' + id, {
                method: 'DELETE'
            })
                .then(resp => {

                    if (resp.ok) {

                        Swal.fire(
                            'Excluído!',
                            'Usuário removido com sucesso.',
                            'success'
                        ).then(() => {
                            location.reload();
                        });

                    } else {

                        Swal.fire(
                            'Erro',
                            'Falha ao excluir usuário.',
                            'error'
                        );

                    }

                })
                .catch(() => {
                    Swal.fire(
                        'Erro',
                        'Erro de conexão com servidor.',
                        'error'
                    );
                });

        }

    });

}