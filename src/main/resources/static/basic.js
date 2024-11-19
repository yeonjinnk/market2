// $(document).ready(function() {
//     $.ajax({
//         type: 'POST',
//         url: `/post`,
//         contentType: 'application/json',
//         data: JSON.stringify(itemDto),
//         success: function (response) {
//             // 2. 응답 함수에서 modal을 뜨게 하고, targetId 를 reponse.id 로 설정
//             $('#container').addClass('active');
//             targetId = response.id;
//         },
//         error(error, status, request) {
//             logout();
//         }
//     })
//
//
//     function showProduct(isAdmin = false) {
//         /**
//          * 관심상품 목록: #product-container
//          * 검색결과 목록: #search-result-box
//          * 관심상품 HTML 만드는 함수: addProductItem
//          */
//
//         let dataSource = null;
//
//         $.ajax({
//             type: 'GET',
//             url: dataSource,
//             contentType: 'application/json',
//             success: function (response) {
//                 $('#product-container').empty();
//                 for (let i = 0; i < response.length; i++) {
//                     let product = response[i];
//                     let tempHtml = addProductItem(product);
//                     $('#product-container').append(tempHtml);
//                 }
//             },
//             error(error, status, request) {
//                 if (error.status === 403) {
//                     $('html').html(error.responseText);
//                     return;
//                 }
//                 logout();
//             }
//         });
//     }
// })