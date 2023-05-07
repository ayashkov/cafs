package org.yashkov.cafs

import kotlin.io.path.Path
import java.nio.file.FileStore
import java.nio.file.FileSystem
import java.nio.file.Path
import java.nio.file.PathMatcher
import java.nio.file.WatchService
import java.nio.file.attribute.UserPrincipalLookupService
import java.nio.file.spi.FileSystemProvider

class CaFileSystem(private val provider: CaFileSystemProvider): FileSystem() {
    override fun close() {
        TODO("Not yet implemented")
    }

    override fun provider(): FileSystemProvider = provider

    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isReadOnly(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSeparator() = "/"

    override fun getRootDirectories(): Iterable<Path> = listOf(Path(""))

    override fun getFileStores(): Iterable<FileStore> {
        TODO("Not yet implemented")
    }

    override fun supportedFileAttributeViews(): Set<String> {
        TODO("Not yet implemented")
    }

    override fun getPath(first: String, vararg more: String): Path {
        TODO("Not yet implemented")
    }

    override fun getPathMatcher(syntaxAndPattern: String): PathMatcher {
        TODO("Not yet implemented")
    }

    override fun getUserPrincipalLookupService(): UserPrincipalLookupService {
        TODO("Not yet implemented")
    }

    override fun newWatchService(): WatchService {
        TODO("Not yet implemented")
    }
}
