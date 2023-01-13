// describe('', () => {
// //log in first
//     beforeEach(() => {
//       cy.visit('http://localhost:3000/login')
//       cy.get('input[name=email]').type('ga@abv.bg')
//       cy.get('input[name=password]').type('1234')
//       cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
//     })
  
//     it('logs in with admin credentials', () => {
//       cy.url().should('include', 'http://localhost:3000')
//       cy.get('#root > div > div.makeStyles-root-9 > header > div > button:nth-child(3)').click()   ;
//       cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(1) > div').type('Aurora')
//       cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(2)').type('Dgrad')
//       cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(3)').type('89.99')
//       cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click()
//     })
// })
// describe('', () => {
   
//     beforeEach(() => {
//         cy.visit('http://localhost:3000')
//       })
    
//         it('creates in with admin credentials', () => {
//             cy.get('#root > div > div.makeStyles-root-1 > header > div > button:nth-child(3)').click()   ;
//             cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(1) > div').type('Aurora')
//                     cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(2)').type('Dgrad')
//                     cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(3)').type('89.99')
//                     cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click()
      
//           })
//     })