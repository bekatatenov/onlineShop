<#import "/spring.ftl" as spring>

<#import "partials/main.ftlh" as main/>

<@main.renderWith>

    <div class="container">
        <div class="card-group"
        <#list foods as food>
            <div class="card col-4" style="width: 18rem;">
                <img src=${food.food.image} class="card-img-top" alt="${food.food.name}">
                <div class="card-body">
                    <h5 class="card-title">${food.food.name}</h5>
                    <p class="card-text">${food.food.description}</p>
                    <p class="card-text">${food.food.gram} gram</p>
                    <p class="card-text">${food.food.price} som</p>
                    <p class="card-text">${food.food.quantity} qty</p>
                    <p class="card-text">${food.food.type.name} type</p>
                </div>
            </div>


            <form action="/basket/delete" method="post">

                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                           value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <div>
                    <input type="hidden" name="foodId" value="${food.food.id}">
                    <button type="submit">Delete from Basket</button>
                </div>
            </form>

        </#list>
    </div>

        <form action="/basket/order" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                       value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Имя:</p>
                    <input type="text" name="name" placeholder="ваше имя" value="${(form.name)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Адрес:</p>
                    <input type="text" name="address" placeholder="ваш адрес почты" value="${(form.address)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text"> Telefon:</p>
                    <input type="text" name="tel" placeholder="ваш адрес почты" value="${(form.tel)!''}">
                </label>
            </div>
            <p>Total : ${form.total} som </p>
            <div>
                <input type="hidden" name="total" value="${form.total}">
                <button type="submit">Make Order</button>
            </div>
        </form>
    </div>
</@main.renderWith>