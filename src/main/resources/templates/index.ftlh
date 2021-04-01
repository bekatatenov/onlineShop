<#import "/spring.ftl" as spring>

<#import "partials/main.ftlh" as main/>

<@main.renderWith>
    <div class="container">
        <div class="card-group">
            <#list foods as food>
                <div class="card" style="width: 18rem; padding: 10px">
                    <img src=${food.image} class="card-img-top" alt="${food.name}">
                    <div class="card-body">
                        <h5 class="card-title">${food.name}</h5>
                        <p class="card-text">${food.description}</p>
                        <p class="card-text">${food.gram} gram</p>
                        <p class="card-text">${food.price} som</p>
                        <p class="card-text">${food.quantity} qty</p>
                        <p class="card-text">${food.type.name} type</p>
                    </div>
                    <div>
                        <button class="btn btn-primary"><a style="color: black" href="/food/${food.id}">Info</a>
                        </button>
                    </div>
                    <div>
                        <#if user??>
                            <form action="/basket/add" method="post">

                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                           value="${(_csrf.token)!'--no-token--'}"/>
                                </#if>
                                <div>
                                    <input type="hidden" name="foodId" value="${food.id}">
                                    <input type="number" name="qty" placeholder="QTY">
                                    <button type="submit">add To Basket</button>
                                </div>
                            </form>
                        </#if>
                    </div>
                </div>
            </#list>
        </div>
    </div>

    <div>
        <#list 1..pages as x>
            <a class="pageButton" href="?page=${x}">${x}</a>
        </#list>
    </div>
</@main.renderWith>
