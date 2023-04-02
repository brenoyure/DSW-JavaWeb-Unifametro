function getIdade() {
    return document.forms["formulario-cadastro"]["idade"].value;
}

function formReset() {
    document.getElementById("formulario-cadastro").reset();
}

/**
 * Verifica se algum campo de número está em branco.
 */
function verificaIdade() {
    let idade = getIdade();
    if (idade < 1) {
        alert("Idade Mínima de 1 ano.");
        formReset();
    }

}