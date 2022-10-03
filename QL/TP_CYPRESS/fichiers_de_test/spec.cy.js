describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:3000')
    cy.contains("Run").click()
    cy.url().should('include','/run/1')
    
    })
})
