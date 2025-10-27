## Project Reflection

### Client Summary

The client for this project was Artemis Financial, a fictional company that required assistance in enhancing the security posture of one of its software applications. The primary issue was to implement specific security features to protect data and communications, including enabling secure transport (HTTPS), ensuring data integrity via checksums, and managing vulnerabilities within third-party dependencies.

### Performance and Value of Security

During this project, I effectively utilized the OWASP dependency-check tool to perform static analysis on the application's dependencies, identifying known vulnerabilities. I successfully implemented HTTPS by generating a self-signed certificate using Java's `keytool` and configuring the Spring Boot application properties. Additionally, I deployed a SHA3-512 hashing algorithm to create a checksum endpoint, providing data integrity verification.


Secure coding is crucial because it directly impacts the confidentiality, integrity, and availability of software and data. It prevents unauthorized access, data breaches, and system compromises. For Artemis Financial, software security adds significant value by building essential customer trust (especially vital in finance), ensuring compliance with regulations like GLBA, protecting the company's reputation, and preventing the high financial and operational costs associated with security incidents.

### Challenges and Helpful Aspects

One challenging aspect was correctly configuring the OWASP dependency-check tool, particularly managing credentials for the OSS Index and understanding the suppression file schema. Differentiating between the assignment's confusing terminology for encryption ciphers and hashing algorithms also required careful attention.

Learning the practical steps for certificate generation with `keytool` and configuring `application.properties` for HTTPS was particularly helpful. Understanding how transitive dependencies contribute to the overall vulnerability landscape was also a key takeaway.



### Security Layers and Future Assessments

I increased security by adding multiple layers (defense-in-depth):
1.  Data Integrity: Implemented SHA3-512 hashing for checksum verification.
2.  Secure Communication: Enabled HTTPS using a self-signed certificate to protect data in transit.
3.  Supply Chain Security: Integrated OWASP dependency-check to identify and manage vulnerabilities in third-party libraries.

In the future, I would use a combination of security tools for vulnerability assessment:
* SCA (Software Composition Analysis): Tools like dependency-check for library vulnerabilities.
* SAST (Static Application Security Testing): Tools that analyze source code for potential flaws.
* DAST (Dynamic Application Security Testing): Tools that test the running application for vulnerabilities.
Decisions on mitigation would be based on risk, considering factors like CVSS scores, exploitability, and potential business impact.

### Ensuring Functionality and Security

Functionality was verified by running the refactored Spring Boot application and successfully accessing the `/greeting` and `/hash` endpoints via `https://localhost:8443` in a web browser. Security was checked by re-running the OWASP dependency-check after applying suppressions to ensure no *new* library vulnerabilities were introduced and that the suppression file worked correctly. The browser's "Not Secure" warning (due to the self-signed certificate) also confirmed that the HTTPS configuration was active.

### Helpful Resources and Practices

Key resources and tools used included:
* Tools: Java `keytool`, OWASP `dependency-check` (Maven plugin), IntelliJ IDEA / Eclipse


* Concepts: HTTPS/TLS, Hashing (SHA3), Dependency Management (Maven), Vulnerability Suppression (`suppression.xml`), Static Analysis (SCA), Self-Signed Certificates.
* Practices: Secure configuration in `application.properties`, Risk triage and justification for suppressing vulnerabilities.

### Demonstrating Skills to Employers

This project demonstrates several valuable skills:
* Implementation of fundamental web security features (HTTPS).
* Understanding and applying cryptographic hashing for data integrity (Checksums).
* Using industry-standard tools (Maven, OWASP Dependency-Check) for managing software supply chain risk.
* Analyzing security reports, triaging findings (identifying false positives/non-exploitable issues), and documenting security configurations.
* Basic Spring Boot application configuration and development.























