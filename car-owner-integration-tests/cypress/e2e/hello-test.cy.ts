describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://10.101.30.151/')
    cy.get('tr').should('have.length', 8);
  })
})
