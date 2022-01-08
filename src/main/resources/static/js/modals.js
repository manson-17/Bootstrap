$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault()
        let href = $(this).attr('href')
        let text = $(this).text()

        if (text === 'Edit') {
            $.get(href, function (user) {
                $('.myEdit #id').val(user.id)
                $('.myEdit #name').val(user.name)
                $('.myEdit #lastname').val(user.lastname)
                $('.myEdit #age').val(user.age)
                $('.myEdit #email').val(user.email)
                $('.myEdit #password').val('')
            })
            $('.myEdit #exampleModal').modal()
        } else if (text === 'New User') {
            $('.myNew #nameNew').val('')
            $('.myNew #lastnameNew').val('')
            $('.myNew #ageNew').val('')
            $('.myNew #emailNew').val('')
            $('.myNew #passwordNew').val('')
            $('.myNew #newUser').modal()
        }
    })

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');

        $.get(href, function (user) {
            $('.myDelete #idD').val(user.id)
            $('.myDelete #nameD').val(user.name)
            $('.myDelete #lastnameD').val(user.lastname)
            $('.myDelete #ageD').val(user.age)
            $('.myDelete #emailD').val(user.email)
        })
            $('.myDelete #myModal').modal();

    })
})

