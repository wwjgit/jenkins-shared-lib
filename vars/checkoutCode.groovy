#!/usr/bin/env groovy

def call(String gitUrl, String branch, targetDir = "") {
    checkout(
        [
            $class: 'GitSCM',
            branches: [[name: "${branch}"]],
            extensions: [
                [
                    $class: 'RelativeTargetDirectory',
                    relativeTargetDir: "${targetDir}"
                ]
            ],
            submoduleCfg: [],
            userRemoteConfigs: [[url: "${gitUrl}"]]
        ]
    )
}
