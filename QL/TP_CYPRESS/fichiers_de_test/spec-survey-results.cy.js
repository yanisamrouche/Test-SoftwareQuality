describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:3000')
    cy.get('tr.sjs-surveys-list__row:nth-child(1) > td:nth-child(2) > a:nth-child(3) > span:nth-child(1)').click()
    cy.url().should('include','/results/1')
    cy.get('.sa-table__entries > select:nth-child(2)').select(0)
    cy.get('.sa-table__global-filter').type('neutral')
    cy.wait(500)
    cy.get('.sa-table__global-filter').type('{enter}')
    cy.wait(500)
    cy.get('.sa-table__global-filter').clear()
    cy.get('#root > div > main > div > div > div.tabulator > div.tabulator-tableHolder > div > div > div:last-child').scrollIntoView({duration:2000},{easing: 'linear'}) 

  })
})
