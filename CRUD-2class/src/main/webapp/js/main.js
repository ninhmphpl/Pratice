function update(id, name, price, description, category){
    let stringCategory = document.getElementById("select").innerHTML
    document.getElementById("update").innerHTML=`
            <form action="products?action=update&id=${id}" method="post">
        <table class="table table-striped">
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${name}">
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <input type="number" name="price" value="${price}">
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td>
                    <input type="text" name="description" value="${description}">
                </td>
            </tr>
            ${stringCategory}
        </table>
        <input type="submit" value="Save">
    </form>
    `
}
function deleteCategory(){

}