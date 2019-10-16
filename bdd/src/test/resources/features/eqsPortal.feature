Feature: Registration of user at EQS Portal

  Scenario: Register new team at EQS Portal
    Given User navigates to EQS Portal for new team registration
    And enter following details for team xyz registration:
      | applicationsSupported | Quality         |
      | featureLeadName       | Mr ABC          |
      | capabilityGMName      | Mr XYZ          |
      | organisation          | Infosys         |
      | location              | India           |
      | requesterName         | HAL 9000        |
      | requesterEmailId      | hal9000@hal.com |
      | securityAnswer        | secret          |
      | gmEmailId             | gm@test.com     |