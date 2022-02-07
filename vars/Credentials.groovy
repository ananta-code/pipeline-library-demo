
def nexusUser=${env.GCP_NEXUS_USER}
def nexusPass=${env.GCP_NEXUS_PASSWORD}

import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.impl.*
import hudson.util.Secret
import java.nio.file.Files
import jenkins.model.Jenkins
import net.sf.json.JSONObject
import org.jenkinsci.plugins.plaincredentials.impl.*
import hudson.security.*

domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

// create credentials for nexus access
store.addCredentials(domain, new StringCredentialsImpl(
        CredentialsScope.GLOBAL,
        "sample-repository-sabre-com-username",
        "Nexus Username",
        Secret.fromString(nexusUser)))
println("Created credentials for gcp-repository-sabre-com-username")

store.addCredentials(domain, new StringCredentialsImpl(
        CredentialsScope.GLOBAL,
        "sample-repository-sabre-com-password",
        "Nexus Password",
        Secret.fromString(nexusPass)))
println("Created credentials for gcp-repository-sabre-com-password")
