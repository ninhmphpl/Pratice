function updateProduct(productCode, name, price, description) {
    console.log(name)
    console.log(price)
    console.log(description)
    document.getElementById("update").innerHTML = `
            <form action="ServletCURD" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="productCode" value="${productCode}">
            Product Name: <input type="text" name="name" value="${name}"> <br>
            Price: <input type="text" name="price" value="${price}"><br>
            Description: <textarea name="description" cols="30" rows="10" style="resize: none" >${description}</textarea> <br>
            <input type="submit" value="Update">
            </form>
    `
}